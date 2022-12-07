package searchengine;

import com.sun.net.httpserver.HttpExchange;
import java.lang.NullPointerException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

 /**
   * Class that handles a search generated on the web page.
   */
public class Search {

  // FIELDS
  private Map<String, Map<String, Page>> pages;
  private final Charset CHARSET = StandardCharsets.UTF_8;
  private List<Page> finalResult;

  // CONSTRUCTOR
  public Search(Map<String, Map<String, Page>> pages) {
    this.pages = pages;
  }

  /**
   * A getter method that return pages.
   * @return pages
   */
  public Map<String, Map<String, Page>> getPages() {
    return pages;
  }

  /**
   * A method that returns finalResult which is a List containing the Pages that are to be shown on the searchengine.
   * @return finalResult
   */
  public List<Page> getFinalResult() {
    return finalResult;
  }

  /**
   * A void method that search for a spicific String input.
   * @param input
   */
  public void search(String input) {
    Hourglass hourglass = new Hourglass();

    populateFinalResult(
      populateResult(cleanSearchterm(input.split("%20OR%20")))
    );

    hourglass.stop();

    if (!(Server.getIo() == null)) {
      respond(
        Server.getIo(),
        200,
        "application/json",
        presentSet(hourglass.execTime(), getFinalResult())
      );
    }
  }

  /**
   * A method that cleans the array searchTermOR and returns searchTerm, which is a List with a List of Strings in it.
   * @param searchTermOR
   * @return searchTerm
   */
  public List<List<String>> cleanSearchterm(String[] searchTermOR) {
    List<List<String>> searchTerm = new ArrayList<>();

    for (String string : searchTermOR) {
      searchTerm.add(Arrays.asList(string.split("%20")));
    }
    return searchTerm;
  }

  /**
   * Takes searchTerm as paramater and uses Queryhandler to create a list over matching Pages.
   * @param searchTerm
   * @return result
   */
  public List<Page> populateResult(List<List<String>> searchTerm) {
    List<Page> result = new ArrayList<>();

    for (int i = 0; i < searchTerm.size(); i++) {
      try {
        Map<String, List<Page>> indexMap = searchList(searchTerm.get(i));

        QueryHandler queryHandler = new QueryHandler();
        result.addAll(queryHandler.handleQuery(indexMap));
      } catch (NullPointerException e) {
        if (!(result.size() > 0)) {
          continue;
        }
      }
    }
    return result;
  }

  /**
   * A method that takes a List with Pages a parameter and checks for dublicate Pages and updates the score on those.
   * @param result
   * @return finalResult
   */
  public List<Page> populateFinalResult(List<Page> result) {
    this.finalResult = new ArrayList<>();

    if (result.size() > 0) {
      for (int i = 0; i < result.size(); i++) {
        if (!finalResult.contains(result.get(i))) {
          finalResult.add(result.get(i));
        } else {
          Page oldPage = finalResult.get(finalResult.indexOf(result.get(i)));
          Page newPage = result.get(i);

          if (oldPage.getScore() < newPage.getScore()) {
            finalResult.remove(oldPage);
            finalResult.add(newPage);
          }
        }
      }
    }
    System.out.println("FINALRESULT: " + finalResult.size());
    return finalResult;
  }

  /**
   * The methods that takes two parameters: execTime (String) and finalResult2 - and iterates over finalResult2
   * and sorts after score and titel. Then it uses an iterator to loop through sortedpagelist and adds it to the responselist which is formatted on the page as bytes.
   * @param execTime
   * @param finalResult2
   * @return bytes
   */
  public byte[] presentSet(String execTime, List<Page> finalResult2) {
    List<String> response = new ArrayList<>();

    if (finalResult2.size() != 0) {
      List<Page> sortedPageList = new ArrayList<>();

      sortedPageList.addAll(finalResult2);
      sortedPageList.sort(
        Comparator
          .comparing(Page::getScore)
          .reversed()
          .thenComparing(Page::getTitle)
      );

      Iterator<Page> it = sortedPageList.iterator();

      while (it.hasNext()) {
        Page i = it.next();

        response.add(
          String.format(
            "{\"url\": \"%s\", \"title\": \"%s\",\"score\": \"%s\"}",
            i.getUrl().substring(6),
            i.getTitle(),
            i.getScore()
          )
        );
      }
      System.out.println("Query took: " + execTime + " seconds.\n");
    }

    byte[] bytes = response.toString().getBytes(CHARSET);
    return bytes;
  }

  /**
   * Filters the wordedindex based on the searchterm.
   * @param searchTerm
   * @return filteredMap
   */
  public Map<String, List<Page>> searchList(List<String> searchTerm) {
    Map<String, List<Page>> filteredMap = new HashMap<>();
    Map<String, List<Page>> newPages = new HashMap<>();

    for (String string : searchTerm) {
      newPages.put(string, new ArrayList<>(pages.get(string).values()));

      filteredMap.putAll(
        newPages
          .entrySet()
          .stream()
          .filter(word -> word.getKey().equals(string))
          .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
      );
    }
    return filteredMap;
  }

  /**
   * A void method that sends the data to the javascript file, which then is presented on the webpage.
   * @param io
   * @param code
   * @param mime
   * @param response
   */
  public void respond(HttpExchange io, int code, String mime, byte[] response) {
    try {
      io
        .getResponseHeaders()
        .set(
          "Content-Type",
          String.format("%s; charset=%s", mime, CHARSET.name())
        );
      io.sendResponseHeaders(200, response.length);
      io.getResponseBody().write(response);
    } catch (Exception e) {} finally {
      io.close();
    }
  }
}

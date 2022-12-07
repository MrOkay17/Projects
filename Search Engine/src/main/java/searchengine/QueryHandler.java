package searchengine;

import java.util.*;

 /**
   * Class that handles all queries generated through the web page.
   */
public class QueryHandler {

  // FIELDS
  private Map<Page, Integer> result;
  private List<Page> pageList;
  private Scoring scoring;

  // CONSTRUCTOR
  public QueryHandler() {
    this.result = new HashMap<>();
    this.pageList = new ArrayList<>();
    this.scoring = new Scoring();
  }

  /**
   * A method that returns the Result map which consist of pages and how many times the page is in the pageList.
   * @return result
   */
  public Map<Page, Integer> getResult() {
    return result;
  }

  /**
   *
   * Method that handles the query. It uses the two methods singleWords and multiplewords, depending on the query,
   * if it consist of either multiplewords, singlewords or both.
   * It then compares the keys in the result and indexmap and look for dublicates pages.
   * If the two maps contains the same page the method adds it to the pagelist.
   * The method then returns the pagelist.
   * @param  indexMap
   * @return pageList
   */
  public List<Page> handleQuery(Map<String, List<Page>> indexMap) {
    if (indexMap.size() > 1) {
      multipleWords(indexMap);
    } else if (indexMap.size() > 0) {
      singleWord(indexMap);
    }

    for (Page page : result.keySet()) {
      if (result.get(page) == indexMap.keySet().size()) {
        pageList.add(page);
      }
    }
    return pageList;
  }

  /**
   * Method that handles a query with multiple words. It takes an indexmap as a argument.
   * Looping through the pages in our indexmap, it checks if the page is in our result. if not it adds it to our result map
   * If our result map contains a page that is the same as our page we loops through, it increments the score in our resultmap.
   * @param indexMap
   */
  public void multipleWords(Map<String, List<Page>> indexMap) {
    for (String word : indexMap.keySet()) {
      for (Page page : indexMap.get(word)) {
        if (!result.containsKey(page)) {
          page.initialiseScore(
            (
              scoring.tfIDF(
                page.getTermCount(),
                page.getUrl(),
                indexMap.get(word).size()
              )
            )
          );
          result.put(page, 1);
        } else if (result.containsKey(page)) {
          for (Page page2 : result.keySet()) {
            if (page2.equals(page)) {
              page2.incrementScore(
                scoring.tfIDF(
                  page.getTermCount(),
                  page.getUrl(),
                  indexMap.get(word).size()
                )
              );
              result.replace(page2, result.get(page2) + 1);
              break;
            }
          }
        }
      }
    }
  }

  /**
   * Method that handles a query with a single word.
   * It is looping through the pages in our indexmap, and creates a score.
   * @param indexMap
   */
  public void singleWord(Map<String, List<Page>> indexMap) {
    Set<String> word = indexMap.keySet();

    for (Page page : indexMap.get(word.toArray()[0])) {
      page.initialiseScore(
        scoring.tfIDF(
          page.getTermCount(),
          page.getUrl(),
          indexMap.values().size()
        )
      );
      result.put(page, 1);
    }
  }
}

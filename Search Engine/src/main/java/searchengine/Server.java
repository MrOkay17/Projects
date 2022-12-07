package searchengine;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

 /**
   * Class that sets up a web server to host the web page.
   */
public class Server {

  // FIELDS
  final int BACKLOG = 0;
  final Charset CHARSET = StandardCharsets.UTF_8;
  HttpServer server;
  Search newSearch;
  Hourglass hourglass;
  static HttpExchange io;

  /**
   * Constructor that takes an int port and a String filename as parameter, and throws IOExceptions and initialises the Server, the Database and the Search.
   * The server also starts the hourglass and stops it when the server is up and running.
   * @param port
   * @param filename
   */
  Server(int port, String filename) throws IOException {
    hourglass = new Hourglass();
    server = HttpServer.create(new InetSocketAddress(port), BACKLOG);
    Database db = new Database(filename);
    newSearch = new Search(db.getInverseIndex());

    server.createContext(
      "/",
      io -> newSearch.respond(io, 200, "text/html", getFile("web/index.html"))
    );
    server.createContext("/search", io -> newSearch.search(ioInput(io)));
    server.createContext(
      "/favicon.ico",
      io ->
        newSearch.respond(io, 200, "image/x-icon", getFile("web/favicon.ico"))
    );
    server.createContext(
      "/code.js",
      io ->
        newSearch.respond(
          io,
          200,
          "application/javascript",
          getFile("web/code.js")
        )
    );
    server.createContext(
      "/style.css",
      io -> newSearch.respond(io, 200, "text/css", getFile("web/style.css"))
    );
    server.start();
    hourglass.stop();

    String msg = " WebServer running on http://localhost:" + port + " ";
    String msg2 = " Boot-up time: " + hourglass.execTime() + " seconds.";

    System.out.println("╭" + "─".repeat(msg.length()) + "╮");
    System.out.println("│" + msg + "│");
    System.out.println("│" + " ".repeat(msg.length()) + "│");
    System.out.println(
      "│" + msg2 + " ".repeat(msg.length() - msg2.length()) + "│"
    );
    System.out.println("╰" + "─".repeat(msg.length()) + "╯");
  }

  /**
   * A method that takes a HttpExchange as parameter and returns input, which is a String translated from that specific HttpExchange.
   * @param io1
   * @return input
   */
  public String ioInput(HttpExchange io1) {
    io = io1;
    String input = io1.getRequestURI().getRawQuery().split("=")[1];

    return input;
  }

  /**
   * A getter method that takes the parameter String filename and returns it in the format byte[].
   * @param filename
   */
  public byte[] getFile(String filename) {
    try {
      return Files.readAllBytes(Paths.get(filename));
    } catch (IOException e) {
      e.printStackTrace();
      return new byte[0];
    }
  }

  /**
   * A getter method that returns the io which is in the format HttpExchange.
   * @return io
   */
  public static HttpExchange getIo() {
    return io;
  }
}

package com.develogical.web;

import java.io.PrintWriter;

public class IndexPage extends HtmlPage {

  @Override
  protected void writeContentTo(PrintWriter writer) {
    writer.println(
        "<h1>Welcome!</h1>"
            + "<p> Enter a query in the box below please, thanks: "
            + "<form><input type=\"text\" name=\"q\" />"
            + "<input type=\"submit\">"
            + "</form>"
            + "</p>");
  }
}

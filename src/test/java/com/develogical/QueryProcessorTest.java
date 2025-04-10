package com.develogical;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class QueryProcessorTest {

  QueryProcessor queryProcessor = new QueryProcessor();

  @Test
  public void returnsEmptyStringIfCannotProcessQuery() {
    assertThat(queryProcessor.process("test"), is(""));
  }

  @Test
  public void knowsAboutShakespeare() {
    assertThat(queryProcessor.process("Shakespeare"), containsString("playwright"));
  }

  @Test
  public void knowsAboutFootball() {
    assertThat(queryProcessor.process("football"), containsString("game"));
  }

  @Test
  public void knowsAboutName() {
    assertThat(queryProcessor.process("What is your name?"), containsString("football-66"));
  }

  @Test
  public void knowsAboutLargestNumber1() {
    assertThat(queryProcessor.process("Which of the following numbers is the largest: 69, 25, 97?"), containsString("97"));
  }

  @Test
  public void knowsAboutLargestNumber2() {
    assertThat(queryProcessor.process("Which of the following numbers is the largest: 28, 51, 62?"), containsString("62"));
  }

  @Test
  public void knowsAboutPlus() {
    assertThat(queryProcessor.process("What is 61 plus 13?"), containsString("74"));
  }

  @Test
  public void knowsAboutMultiple() {
    assertThat(queryProcessor.process("What is 7 multiplied by 21?"), containsString("147"));
  }

}

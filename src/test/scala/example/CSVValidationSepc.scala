package com.thecoders

import org.scalatest.flatspec.AnyFlatSpec

import example.Calculator
import org.scalatest.matchers.should.Matchers
import java.time.ZonedDateTime
import java.util.UUID

class CSVValidationSepc extends AnyFlatSpec with Matchers {

  "csv validator" should "process the data succesfully" in {
  }


}


object CSVValidationSepc {

  // TODO would extractin the abstraction for the ADD, DLETE, UPDATE for the record would good idea?
  case class Book(
    id:             UUID,
    title:          String,
    author:         String,
    dateOfRelease: ZonedDateTime
  )

  val books = List(
    Book(UUID, "The las wish", "A. Sapkowski", ZonedDateTime.of())
  )

}

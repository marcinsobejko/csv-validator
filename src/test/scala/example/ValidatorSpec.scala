package com.thecoders

import org.scalatest.flatspec.AnyFlatSpec

import org.scalatest.matchers.should.Matchers
import java.time.ZonedDateTime
import java.util.UUID

import ValidatorSpec.TheLastWishBook
import ValidatorSpec.HarryPotterBook
import ValidatorSpec.BooksDuplicationValidator

class ValidatorSpec extends AnyFlatSpec with Matchers {

  "books validator" should "find duplicated values" in {
    val books = List(TheLastWishBook, TheLastWishBook)

    val result = new Validator(List(new BooksDuplicationValidator(books))).valid(books)

    result should contain only Error("Given book The last wish with id: a2d2a2e3-940c-441b-83f0-214607c41495 is duplicated")
  }

}

object ValidatorSpec {

  case class Book(
    id: UUID,
    title: String,
    author: String,
    dateOfRelease: ZonedDateTime
  )

  val TheLastWishBook = Book(UUID.fromString("a2d2a2e3-940c-441b-83f0-214607c41495"), "The last wish", "A. Sapkowski", ZonedDateTime.now())

  val HarryPotterBook = Book(
    UUID.fromString("a2d2a2e3-940c-441b-83f0-214607c41480"),
    "Harry Potter and the Sorcerer's stone",
    "J.K Rowling",
    ZonedDateTime.now()
  )

  class BooksDuplicationValidator(books: Seq[Book]) extends SingleEntityValidator[Book] {

    override def valid(entity: Book): Either[Error, Unit] =
      if (books.count(_.equals(entity)) >= 2)
        Left(Error(s"Given book ${entity.title} with id: ${entity.id} is duplicated"))
      else
        Right(())

  }

}

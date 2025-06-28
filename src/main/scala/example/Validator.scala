package com.thecoders

class Validator[E](
  val validators: Seq[SingleEntityValidator[E]]
) {

  def valid[T](entities: Seq[E]): Seq[Error] = entities.foldLeft(Seq.empty[Error]) { (acc, entity) =>
    acc ++ validators
      .map(validator => validator.valid(entity))
      .flatMap {
        case Left(error) => List(error)
        case Right(_)    => List.empty[Error]
      }
  }

}

trait SingleEntityValidator[E] {

  def valid(enity: E): Either[Error, Unit]
}

case class Error(message: String)

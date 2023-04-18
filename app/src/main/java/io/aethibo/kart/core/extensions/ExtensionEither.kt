package io.aethibo.kart.core.extensions

import io.aethibo.kart.core.exception.Failure
import io.aethibo.kart.core.exception.toError
import io.aethibo.kart.core.functional.Either
import kotlinx.coroutines.TimeoutCancellationException
import kotlin.coroutines.cancellation.CancellationException

typealias Result<T> = Either<Failure, T>

inline fun <T> resultOfEither(block: () -> T): Result<T> {
   return try {
      Either.Right(block())
   } catch (timeout: TimeoutCancellationException) {
      Either.Left(timeout.toError())
   } catch (cancellation: CancellationException) {
      Either.Left(cancellation.toError())
   } catch (exception: Exception) {
      Either.Left(exception.toError())
   }
}

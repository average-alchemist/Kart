package io.aethibo.kart.core.extensions

import io.aethibo.kart.core.exception.Failure
import io.aethibo.kart.core.exception.toError
import io.aethibo.kart.core.functional.Either
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ServerResponseException
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
   } catch (exception: RedirectResponseException) {
      // 3xx - responses
      Either.Left(exception.toError())
   } catch (exception: ClientRequestException) {
      // 4xx - responses
      Either.Left(exception.toError())
   } catch (exception: ServerResponseException) {
      // 5xx - responses
      Either.Left(exception.toError())
   } catch (exception: Exception) {
      Either.Left(exception.toError())
   }
}

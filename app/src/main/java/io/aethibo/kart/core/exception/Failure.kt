package io.aethibo.kart.core.exception

import io.aethibo.kart.core.exception.Failure.FeatureFailure
import retrofit2.HttpException
import java.io.IOException

/**
 * Base Class for handling errors/failures/exceptions.
 * Every feature specific failure should extend [FeatureFailure] class.
 */
sealed class Failure {
   object NetworkConnection : Failure()
   class Server(val code: Int) : Failure()

   class Unknown(val message: String) : Failure()

   /** * Extend this class for feature specific failures.*/
   abstract class FeatureFailure : Failure()
}

fun Exception.toError(): Failure = when (this) {
   is IOException -> Failure.NetworkConnection
   is HttpException -> Failure.Server(code())
   else -> Failure.Unknown(message ?: "")
}
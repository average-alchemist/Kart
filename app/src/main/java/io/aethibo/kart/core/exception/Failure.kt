package io.aethibo.kart.core.exception

import io.aethibo.kart.core.exception.Failure.Cancellation
import io.aethibo.kart.core.exception.Failure.Client
import io.aethibo.kart.core.exception.Failure.FeatureFailure
import io.aethibo.kart.core.exception.Failure.NetworkConnection
import io.aethibo.kart.core.exception.Failure.Redirect
import io.aethibo.kart.core.exception.Failure.Server
import io.aethibo.kart.core.exception.Failure.Timeout
import io.aethibo.kart.core.exception.Failure.Unknown
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ServerResponseException
import kotlinx.coroutines.TimeoutCancellationException
import java.io.IOException
import kotlin.coroutines.cancellation.CancellationException

/**
 * Base Class for handling errors/failures/exceptions.
 * Every feature specific failure should extend [FeatureFailure] class.
 */
sealed class Failure {
   object NetworkConnection : Failure()
   object Server : Failure()
   object Redirect : Failure()
   object Client : Failure()
   object Timeout : Failure()
   object Cancellation : Failure()
   class Unknown(val message: String) : Failure()

   /** * Extend this class for feature specific failures.*/
   abstract class FeatureFailure : Failure()
}

fun Exception.toError(): Failure = when (this) {
   is IOException -> NetworkConnection
   is RedirectResponseException -> Redirect
   is ClientRequestException -> Client
   is ServerResponseException -> Server
   is TimeoutCancellationException -> Timeout
   is CancellationException -> Cancellation
   else -> Unknown(message ?: "")
}
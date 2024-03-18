package eu.symmetrysought.raspberryjam

import io.micronaut.core.annotation.NonNull
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
//import io.opentelemetry.instrumentation.annotations.SpanAttribute
//import io.opentelemetry.instrumentation.annotations.WithSpan
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Controller("/")
open class GetController {
    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    @Produces(MediaType.TEXT_HTML)
    @Get("/{purpose}/{project}/{branch}/{path0}/{path1}/{path2}")
    open fun getLizardWizard(@NonNull purpose: String, @NonNull project: String, @NonNull branch: String, @NonNull path0: String, @NonNull path1: String, @NonNull path2: String, request: HttpRequest<*>): HttpResponse<*> {
        //gcloud auth application-default login
        var body = "<html><head><title>api lizard</title><body>API wizard - laggdax"
        logger.info("Logger lizard!")
        logger.info(request.uri.toASCIIString())
        request.parameters.forEach {
            body += "${it.key}=${it.value}<br />"
            it.value.forEach {
                body += "$it<br />"
            }
            logger.info("${it.key}=${it.value}")
        }

        body += eu.symmetrysought.raspberryjam.kts.simpleLoader.main("7 + 11")

        try {
            val res = eu.symmetrysought.raspberryjam.kts.fromFile.main("/Users/VIP/dev/github.com/a-cosmic-jaw/raspberryjam-app/worker/src/main/kotlin/scripts/test.simplescript.kts")
            body += "<br />" + res.configuration
        }
        catch (e: Exception) {
            logger.warn(e.message)
        }
        body += "</body></html>"

        return HttpResponse.ok(body).contentType(MediaType.TEXT_HTML)
    }
}
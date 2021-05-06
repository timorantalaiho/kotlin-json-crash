import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Test

class CrashingJsonSerializationTest {
    @Test
    fun bar() {
        val failingString = "{\"status\":123,\"message\":\"content\",\"path\":\"/here/beeeeeeeeeeee/dragoons/d63574f-705c-49dd-a6bc-c8d1e524eefd/\"}"
        val o = MyObject(failingString)
        System.err.println(Json.encodeToString(MyObject.serializer(), o))
    }

    @Serializable
    data class MyObject(val text: String)
}

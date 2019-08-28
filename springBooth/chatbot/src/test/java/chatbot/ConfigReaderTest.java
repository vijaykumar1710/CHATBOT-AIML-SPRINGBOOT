/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package chatbot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import com.main.testSudeep.ConfigMapperMock;
import com.main.testSudeep.ConfigReader;

class ConfigReaderTest {

  @Test
  void testGetParameterValue() {
    final ConfigReader configReader = new ConfigReader(new ConfigMapperMock());
    final String actual = configReader.getParameterValue("displayFormat");
    assertEquals("4x4", actual);
  }

}

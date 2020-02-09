    package org.example.resources;


    import io.dropwizard.testing.junit5.ResourceExtension;

    import org.junit.ClassRule;
    import org.junit.Test;

    import javax.ws.rs.core.MediaType;

    import static org.junit.Assert.assertEquals;

    public class HelloResourceTest {

        @ClassRule
        public static final ResourceExtension Rule=ResourceExtension.builder()
                    .addResource(new HelloResource())
                    .build();
        @Test
        public void testhello()
        {
            String expected="hello world!!!!!";
            String actual=Rule.getJerseyTest().target("/hello").request(MediaType.TEXT_PLAIN).get(String.class);
            assertEquals(expected,actual);

        }
    }

package sky.group.homeworkgroup.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import sky.group.homeworkgroup.logic.Logic;
import sky.group.homeworkgroup.model.OutputData;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class ServiceTest {
    @Mock
    private Logic logic;

    private ServiceClient serviceClient;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        serviceClient = new ServiceClient(logic);
    }

    @Test
    void testSearchForRecommendations() {
        UUID testId = UUID.randomUUID();
        when(logic.analise(testId)).thenReturn(List.of(UUID.fromString("147f6a0f-3b91-413b-ab99-87f081d60d5a")));

        List<OutputData> result = serviceClient.searchForRecommendations(testId);

        assertNotNull(result);
        // Additional assertions can be added here to verify the contents of the result
    }
}

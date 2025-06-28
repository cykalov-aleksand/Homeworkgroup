package sky.group.homeworkgroup.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import sky.group.homeworkgroup.model.modeljbd.InformationClient;
import sky.group.homeworkgroup.repository.ProjectRepository;
import sky.group.homeworkgroup.service.logic.Logic;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class LogicTest {
    @Mock
    private ProjectRepository projectRepository;

    private Logic logic;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        logic = new Logic(projectRepository);
    }

    @Test
    void testNoTransactions() {
        UUID testId = UUID.randomUUID();
        when(projectRepository.getListTransactions(testId)).thenReturn(Collections.emptyList());

        List<UUID> result = logic.analise(testId);

        assertEquals(0, result.size());
    }



    // Additional tests for other corner cases can be added here
}

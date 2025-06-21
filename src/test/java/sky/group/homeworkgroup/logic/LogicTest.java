package sky.group.homeworkgroup.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import sky.group.homeworkgroup.model.modeljbd.InformationClient;
import sky.group.homeworkgroup.repository.ProjectRepository;

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

    @Test
    void testEdgeCaseTransactions() {
        UUID testId = UUID.randomUUID();
        InformationClient transaction1 = new InformationClient("DEBIT", "DEPOSIT", 1000);
        InformationClient transaction2 = new InformationClient("DEBIT", "EXPENSE", 100_000);
        when(projectRepository.getListTransactions(testId)).thenReturn(List.of(transaction1, transaction2));

        List<UUID> result = logic.analise(testId);

        assertEquals(1, result.size());
        assertEquals(UUID.fromString("ab138afb-f3ba-4a93-b74f-0fcee86d447f"), result.get(0));
    }

    // Additional tests for other corner cases can be added here
}

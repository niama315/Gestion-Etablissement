package eu.ensup.etablissementscolaire;

import eu.ensup.etablissementscolaire.exception.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TestServiceSpy {


    @Spy
    IEtudiantService spy;

    @Test
    public void testSpy() throws ServiceException {
        when(spy.delete(2)).thenReturn(1);
        assertEquals(spy.delete(2), 1);
        verify(spy).delete(2);

    }
}

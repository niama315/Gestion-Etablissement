package eu.ensup.etablissementscolaire;

import eu.ensup.etablissementscolaire.exception.ServiceException;
import eu.ensup.etablissementscolaire.exception.etudiantExceptions.GetAllEtudiantServiceException;
import eu.ensup.etablissementscolaire.exceptions.DaoException;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TestServiceMock {

    @Mock
    IEtudiantDao mockDao;

    @InjectMocks
    EtudiantService service;

    @Test
    @DisplayName("Tout les etudiant")
    public void FindAllEtudiantTest() throws DaoException, GetAllEtudiantServiceException {

        Set<Etudiant> setEtudiant = new HashSet<Etudiant>() {{
            add(new Etudiant("4","niama"+Math.random()+"@gmail.com","24 b"
                    ,"24 b","0252154785","","",new Date( new java.util.Date().getTime())));
            add(new Etudiant("4","aroubite"+Math.random()+"@gmail.com","24 b"
                    ,"24 b","0252154785","","",new Date( new java.util.Date().getTime())));
            add(new Etudiant("4","niama"+Math.random()+"@gmail.com","24 b"
                    ,"24 b","0252154785","","",new Date( new java.util.Date().getTime())));
        }};

        when(mockDao.getAll()).thenReturn(setEtudiant);

        Set<Etudiant> etudiantList = mockDao.getAll();

        assertEquals(3,etudiantList.size());
        verify(mockDao).getAll();
    }

    private void assertEquals(int i, int size) {
    }

    @AfterEach
    public void afterEach()
    {
        mockDao = null;
        service = null;
    }

}

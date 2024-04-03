package correlativas;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class InscripcionTest {

    Materia AyEdD = new Materia();
    Materia PdP = new Materia(new Materia[] { AyEdD });
    Materia AdS = new Materia();
    Materia DdS = new Materia(new Materia[] { AyEdD, AdS });
    Alumno AlumnoTesteado = new Alumno(new Materia[] { AyEdD });

    @Test
    public void IncripcionCumpleCorrelatividades() {
        Inscripcion InscripcionValida = new Inscripcion(new Materia[] { PdP, AdS }, AlumnoTesteado);
        assertTrue(InscripcionValida.Aprobada());
    }

    @Test
    public void IncripcionNoCumpleCorrelatividades() {
        Inscripcion InscripcionInvalida = new Inscripcion(new Materia[] { DdS }, AlumnoTesteado);
        assertFalse(InscripcionInvalida.Aprobada());
    }
}

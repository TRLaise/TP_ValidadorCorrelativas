package correlativas;

class Inscripcion {
    Alumno AlumnoSolicitante = null;
    Materia[] MateriasSolicitadas = {};

    Inscripcion(Materia[] Solicitadas, Alumno Solicitante) {
        this.MateriasSolicitadas = Solicitadas;
        this.AlumnoSolicitante = Solicitante;
    }

    boolean Aprobada() {
        for (Materia materia : MateriasSolicitadas) {
            if (!materia.CumpleCorrelativas(AlumnoSolicitante.MateriasAprobadas)) {
                return false;
            }
        }
        return true;
    }
}

class Alumno {
    Materia[] MateriasAprobadas = {};

    Alumno() {
        this.MateriasAprobadas = new Materia[0];
    }

    Alumno(Materia[] Aprobadas) {
        this.MateriasAprobadas = Aprobadas;
    }
}

class Materia {
    Materia[] MateriasCorrelativas = {};

    Materia() {
        this.MateriasCorrelativas = new Materia[0];
    }

    Materia(Materia[] Correlativas) {
        this.MateriasCorrelativas = Correlativas;
    }

    boolean CumpleCorrelativas(Materia[] MateriasAprobadas) {

        for (Materia correlativa : MateriasCorrelativas) {

            boolean encontrada = false;

            for (Materia aprobada : MateriasAprobadas) {
                if (aprobada.equals(correlativa)) {
                    encontrada = true;
                    break;
                }
            }

            if (!encontrada) {
                return false;
            }
        }

        return true;
    }
}
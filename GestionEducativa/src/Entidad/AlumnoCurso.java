package Entidad;

public class AlumnoCurso {
	
	private int id;
	private Alumno alumno;
	private Curso curso;
	private int nota1;
	private int nota2;
	private int nota3;
	private int nota4;
	private boolean estado;
	public AlumnoCurso() {
		
	}
	
	public AlumnoCurso(int id, Alumno alumno, Curso curso, int nota1, int nota2, int nota3, int nota4, boolean estado) {
		
		this.id = id;
		this.alumno = alumno;
		this.curso = curso;
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.nota3 = nota3;
		this.nota4 = nota4;
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public int getNota1() {
		return nota1;
	}

	public void setNota1(int nota1) {
		this.nota1 = nota1;
	}

	public int getNota2() {
		return nota2;
	}

	public void setNota2(int nota2) {
		this.nota2 = nota2;
	}

	public int getNota3() {
		return nota3;
	}

	public void setNota3(int nota3) {
		this.nota3 = nota3;
	}

	public int getNota4() {
		return nota4;
	}

	public void setNota4(int nota4) {
		this.nota4 = nota4;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "AlumnoCurso [id=" + id + ", alumno=" + alumno + ", curso=" + curso + ", nota1=" + nota1 + ", nota2="
				+ nota2 + ", nota3=" + nota3 + ", nota4=" + nota4 + ", estado=" + estado + "]";
	}
	
	
}

package model;

public class Aluno extends Pessoa{
	private String curso;
	private int semestre;
	private int cop=20; 
	private String dt;
	
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public int getSemestre() {
		return semestre;
	}
	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}
	public int getCop() {
		return cop;
	}
	public void setCop(int cop) {
		this.cop = cop;
	}

	public String getDt() {
		return dt;
	}

	public void setDt(String dt) {
		this.dt = dt;
	}
	

}

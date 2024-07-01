package clases;

public class Tiendas {
	
	private int codigo, nempleados;
    private String departamento, provincia, distrito;  
    
    public Tiendas(int codigo, String departamento, String provincia, String distrito, int nempleados) {
        this.codigo = codigo;
        this.departamento = departamento;
        this.provincia = provincia;
        this.distrito = distrito;
        this.nempleados = nempleados;
    }

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getNempleados() {
		return nempleados;
	}

	public void setNempleados(int nempleados) {
		this.nempleados = nempleados;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
    
    

}

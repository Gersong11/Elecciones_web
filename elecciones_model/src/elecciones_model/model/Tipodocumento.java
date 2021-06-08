package elecciones_model.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipodocumento database table.
 * 
 */
@Entity
@NamedQuery(name="Tipodocumento.findAll", query="SELECT t FROM Tipodocumento t")
public class Tipodocumento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String descripcion;

	//bi-directional many-to-one association to Votante
	@ManyToOne
	@JoinColumn(name="votante")
	private Votante votanteBean;

	//bi-directional many-to-one association to Votante
	@OneToMany(mappedBy="tipodocumentoBean")
	private List<Votante> votantes;

	public Tipodocumento() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Votante getVotanteBean() {
		return this.votanteBean;
	}

	public void setVotanteBean(Votante votanteBean) {
		this.votanteBean = votanteBean;
	}

	public List<Votante> getVotantes() {
		return this.votantes;
	}

	public void setVotantes(List<Votante> votantes) {
		this.votantes = votantes;
	}

	public Votante addVotante(Votante votante) {
		getVotantes().add(votante);
		votante.setTipodocumentoBean(this);

		return votante;
	}

	public Votante removeVotante(Votante votante) {
		getVotantes().remove(votante);
		votante.setTipodocumentoBean(null);

		return votante;
	}

}
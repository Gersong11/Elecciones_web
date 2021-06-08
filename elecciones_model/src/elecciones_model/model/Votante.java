package elecciones_model.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the votante database table.
 * 
 */
@Entity
@NamedQuery(name="Votante.findAll", query="SELECT v FROM Votante v")
public class Votante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String documento;

	private String email;

	private String nombre;

	//bi-directional many-to-one association to Tipodocumento
	@OneToMany(mappedBy="votanteBean")
	private List<Tipodocumento> tipodocumentos;

	//bi-directional many-to-one association to Eleccion
	@ManyToOne
	@JoinColumn(name="eleccion")
	private Eleccion eleccionBean;

	//bi-directional many-to-one association to Tipodocumento
	@ManyToOne
	@JoinColumn(name="tipodocumento")
	private Tipodocumento tipodocumentoBean;

	//bi-directional many-to-one association to Voto
	@OneToMany(mappedBy="votanteBean")
	private List<Voto> votos;

	public Votante() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDocumento() {
		return this.documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Tipodocumento> getTipodocumentos() {
		return this.tipodocumentos;
	}

	public void setTipodocumentos(List<Tipodocumento> tipodocumentos) {
		this.tipodocumentos = tipodocumentos;
	}

	public Tipodocumento addTipodocumento(Tipodocumento tipodocumento) {
		getTipodocumentos().add(tipodocumento);
		tipodocumento.setVotanteBean(this);

		return tipodocumento;
	}

	public Tipodocumento removeTipodocumento(Tipodocumento tipodocumento) {
		getTipodocumentos().remove(tipodocumento);
		tipodocumento.setVotanteBean(null);

		return tipodocumento;
	}

	public Eleccion getEleccionBean() {
		return this.eleccionBean;
	}

	public void setEleccionBean(Eleccion eleccionBean) {
		this.eleccionBean = eleccionBean;
	}

	public Tipodocumento getTipodocumentoBean() {
		return this.tipodocumentoBean;
	}

	public void setTipodocumentoBean(Tipodocumento tipodocumentoBean) {
		this.tipodocumentoBean = tipodocumentoBean;
	}

	public List<Voto> getVotos() {
		return this.votos;
	}

	public void setVotos(List<Voto> votos) {
		this.votos = votos;
	}

	public Voto addVoto(Voto voto) {
		getVotos().add(voto);
		voto.setVotanteBean(this);

		return voto;
	}

	public Voto removeVoto(Voto voto) {
		getVotos().remove(voto);
		voto.setVotanteBean(null);

		return voto;
	}

}
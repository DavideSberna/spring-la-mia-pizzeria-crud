package org.java.app.db.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pizza {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(unique = true)
	private String nome;
	
	private String descrizione;
	
	private String image;
	
	private double prezzo;
	
	private int voto;
	
	private boolean allergeni;
	
	
	 
	public Pizza() {}
	public Pizza(String nome, String descrizione, String image, double prezzo, int voto, boolean allergeni) {
		setNome(nome);
		setDescrizione(descrizione);
		setImage(image);
		setPrezzo(prezzo);
		setVoto(voto);
		setAllergeni(allergeni);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Il nome non può essere vuoto o composto solo da spazi.");
        }
		this.nome = nome;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		if (descrizione == null || descrizione.trim().isEmpty()) {
            throw new IllegalArgumentException("La descrizione non può essere vuota o composto solo da spazi.");
        }
		this.descrizione = descrizione;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		if (image == null || image.trim().isEmpty()) {
            throw new IllegalArgumentException("L'immagine non può essere vuota o composto solo da spazi.");
        }
		this.image = image;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		if (prezzo <= 0) {
            throw new IllegalArgumentException("Il prezzo non può essere 0 o minore.");
        }
		this.prezzo = prezzo;
	}
	
	public int getVoto() {
		return voto;
	}
	public void setVoto(int voto) {
		if (voto < 0) {
            throw new IllegalArgumentException("Il voto non può essere minore di 0.");
        }
		this.voto = voto;
	}
	public boolean isAllergeni() {
		return allergeni;
	}
	public void setAllergeni(boolean allergeni) {
		this.allergeni = allergeni;
	}
	
	
	@Override
	public String toString() {
		
		return "[" + getId() + "] Pizza:\n" +
				"nome: " + getNome() + "\n"+ 
				"descrizione: " + getDescrizione() + "\n"+
				"prezzo: " + getPrezzo() + "\n";
		
	}
	 

}

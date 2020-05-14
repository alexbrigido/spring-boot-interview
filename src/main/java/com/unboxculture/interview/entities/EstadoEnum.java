package com.unboxculture.interview.entities;

public enum EstadoEnum {

	AC,
	AL,
	AP,
	AM,
	BA,
	CE,
	DF,
	ES,
	GO,
	MA,
	MT,
	MS,
	MG,
	PA,
	PB,
	PR,
	PE,
	PI,
	RJ,
	RN,
	RS,
	RO,
	RR,
	SC,
	SP,
	SE,
	TO;

	public static EstadoEnum fromSigla(String estado) {
		for(EstadoEnum e : EstadoEnum.values()) {
			if(e.name().equalsIgnoreCase(estado)) {
				return e;
			}
		}
		return null;
	}
	
}

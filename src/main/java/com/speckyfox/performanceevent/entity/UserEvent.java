package com.speckyfox.performanceevent.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.persistence.Id;
import java.io.Serializable;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class UserEvent implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private Users user;

	@ManyToOne
	@JoinColumn(name = "event_id", referencedColumnName = "id")
	private Events event;

}
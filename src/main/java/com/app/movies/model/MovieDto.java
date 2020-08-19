package com.app.movies.model;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({"id", "title", "category", "rating"})
public class MovieDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5368526870050652914L;

	private MovieDto() {}
	
	private MovieDto(MovieDtoBuilder builder) {
		this.id = builder.id;
		this.title = builder.title;
		this.category = builder.category;
		this.rating = builder.rating;
	}
	
	@JsonProperty(value = "id")
	private Long id;

	@JsonProperty(value = "title")
	private String title;
	
	@JsonProperty(value = "category")
	private String category;
	
	@JsonProperty(value = "rating")
	private Double rating;

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public Double getRating() {
		return rating;
	}
	
	public static class MovieDtoBuilder {
		
		@JsonProperty(value = "id")
		private Long id;

		@JsonProperty(value = "title")
		private String title;
		
		@JsonProperty(value = "category")
		private String category;
		
		@JsonProperty(value = "rating")
		private Double rating;
		
		public MovieDtoBuilder() {}
		
		public MovieDtoBuilder setId(Long id) {
			this.id = id;
			return this;
		}

		public MovieDtoBuilder setTitle(String title) {
			this.title = title;
			return this;
		}
		
		public MovieDtoBuilder setCategory(String category) {
			this.category = category;
			return this;
		}
		
		public MovieDtoBuilder setRating(Double rating) {
			this.rating = rating;
			return this;
		}
		
		public MovieDto build() {
			return new MovieDto(this);
		}
	}
	
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public boolean equals(final Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}

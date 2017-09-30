package com.orenk.triangle.data;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("triangle")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TriangleDTO {

    @JsonProperty("id")
    Long id;
    @JsonProperty("edge_a")
    Integer edgeA;
    @JsonProperty("edge_b")
    Integer edgeB;
    @JsonProperty("hypotenuse_edge")
    Double hypotenuseEdge;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getEdgeA() {
        return edgeA;
    }

    public void setEdgeA(Integer edgeA) {
        this.edgeA = edgeA;
    }

    public Integer getEdgeB() {
        return edgeB;
    }

    public void setEdgeB(Integer edgeB) {
        this.edgeB = edgeB;
    }

    public Double getHypotenuseEdge() {
        return hypotenuseEdge;
    }

    public void setHypotenuseEdge(Double hypotenuseEdge) {
        this.hypotenuseEdge = hypotenuseEdge;
    }

    @Override
    public String toString() {
        return "TriangleDTO{" +
                "id=" + id +
                ", edgeA=" + edgeA +
                ", edgeB=" + edgeB +
                ", hypotenuseEdge=" + hypotenuseEdge +
                '}';
    }

    public TriangleDTO(Long id, Integer edgeA, Integer edgeB, Double hypotenuseEdge) {
        this.id = id;
        this.edgeA = edgeA;
        this.edgeB = edgeB;
        this.hypotenuseEdge = hypotenuseEdge;
    }
}

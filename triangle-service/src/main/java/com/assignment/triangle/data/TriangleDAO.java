package com.assignment.triangle.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="triangles")
public class TriangleDAO {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "edge_a")
    private Integer edgeA;
    @Column(name = "edge_b")
    private Integer edgeB;
    @Column(name="hypotenuse_edge",precision = 2, scale = 6)
    private Double hypotenuse;
    @Column(name="state")
    private CalcState state = CalcState.PRE;

    public TriangleDAO(Long id, Integer edgeA, Integer edgeB, Double hypotenuseEdge) {
        this.id = id;
        this.edgeA = edgeA;
        this.edgeB = edgeB;
        this.hypotenuse = hypotenuseEdge;
    }

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

    public Double getHypotenuse() {
        return hypotenuse;
    }

    public void setHypotenuse(Double hypotenuse) {
        this.hypotenuse = hypotenuse;
    }

    public CalcState getState() {
        return state;
    }

    public void setState(CalcState state) {
        this.state = state;
    }

    public TriangleDAO() {
    }

    public TriangleDAO(Integer edgeA, Integer edgeB) {
        this.edgeA = edgeA;
        this.edgeB = edgeB;
    }

    public TriangleDAO(Long id, Integer edgeA, Integer edgeB, Double hypotenuse, CalcState state) {
        this.id = id;
        this.edgeA = edgeA;
        this.edgeB = edgeB;
        this.hypotenuse = hypotenuse;
        this.state = state;
    }

    @Override
    public String toString() {
        return "TriangleDAO{" +
                "id=" + id +
                ", edgeA=" + edgeA +
                ", edgeB=" + edgeB +
                ", hypotenuse=" + hypotenuse +
                ", state=" + state +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TriangleDAO that = (TriangleDAO) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}

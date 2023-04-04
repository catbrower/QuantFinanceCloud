package com.brower.quantfinance.strategy;

import org.apache.commons.math3.geometry.Point;
import org.apache.commons.math3.ml.clustering.CentroidCluster;
import org.apache.commons.math3.ml.clustering.KMeansPlusPlusClusterer;
import org.apache.commons.math3.ml.distance.EuclideanDistance;

import java.util.List;

// http://www.java2s.com/example/java-api/org/apache/commons/math3/ml/clustering/kmeansplusplusclusterer/kmeansplusplusclusterer-3-0.html
public class KMeansStrategy extends Strategy {
    final int defaultMaxIter = 1000;
    private int clusters;
    private KMeansPlusPlusClusterer kmeansClusterer;
    private List<CentroidCluster> centroids;

    public KMeansStrategy(int clusters) {
        this.clusters = clusters;
        this.kmeansClusterer = new KMeansPlusPlusClusterer(clusters, defaultMaxIter, new EuclideanDistance());
    }

    public void Cluster(List<Point> dataPoints) {
        centroids = kmeansClusterer.cluster(dataPoints);
    }
}

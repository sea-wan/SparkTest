package com.wan.bigdata.spark.core.rdd.operator.transform

import org.apache.spark.{SparkConf, SparkContext}

/**
 * Author: wanyingfei
 * Date: 2022/5/30 19:18
 * Description:
 * Version: 1.0
 */
object Transform_repartition {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("transform_repartition")
    val sc = new SparkContext(sparkConf)

    val rdd = sc.makeRDD(List(1, 2, 3, 4, 5, 6), 2)
    rdd.repartition(3).saveAsTextFile("datas/output2.txt")

    sc.stop()
  }
}

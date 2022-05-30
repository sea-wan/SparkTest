package com.wan.bigdata.spark.core.rdd.operator.transform

import org.apache.spark.{SparkConf, SparkContext}

/**
 * Author: wanyingfei
 * Date: 2022/5/30 19:04
 * Description:
 * Version: 1.0
 */
object Transform_distinct {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("transform_distinct")
    val sc = new SparkContext(sparkConf)

    sc.makeRDD(List(1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10)).distinct().collect().foreach(println)

  }

}

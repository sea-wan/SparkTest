package com.wan.bigdata.spark.core.rdd.operator.transform

import org.apache.spark.{SparkConf, SparkContext}

/**
 * Author: wanyingfei
 * Date: 2022/5/30 16:08
 * Description:
 * Version: 1.0
 */
object Transform_sample {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("transform_sample")
    val sc = new SparkContext(sparkConf)

    val rdd = sc.makeRDD(List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))

    // 抽样, true表示抽样放回, 5代表每条数据抽样可能的次数  ,第三个参数 随机数种子 如果不传递参数则每次都是不同的
    rdd.sample(true, 5 ).collect().foreach(println)

    //false 代表没有放回抽样, true 代表有放回抽样, 0.3 代表抽样的概率
    rdd.sample(false, 0.3 ).collect().foreach(println)

    sc.stop()
  }

}

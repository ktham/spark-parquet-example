import org.apache.spark.{SparkContext, SparkConf}
import org.apache.spark.sql.SQLContext
import org.apache.spark.rdd.RDD

object ParquetExample {

  case class Record(key: Int, value: String)

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[2]").setAppName("ParquetExample")
    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)
    import sqlContext._

    val rdd: RDD[Record] = sc.parallelize((1 to 100).map(i => Record(i, s"val_$i")))

    // This is fine
    rdd.saveAsTextFile("data/records.txt")

    // This is not
    rdd.saveAsParquetFile("data/records.parquet")
  }
}

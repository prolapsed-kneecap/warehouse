import PackageInfo.typeToAmount
import java.lang.Exception
import kotlin.random.Random
import kotlin.random.asJavaRandom
import kotlin.random.nextInt

class Store {
    fun order() {
        var orderOptions = mutableListOf<Int>()
        PackageInfo.typeToAmount.forEach {
            if (it.second > 0)
                orderOptions.add(it.first)
        }
        var randType = 1
        var randAmount = 1
        if (orderOptions.size>=1){
            if (orderOptions.size==1)
                randType=1
            else
                randType = Random.nextInt(1, orderOptions.size)
            if (PackageInfo.typeToAmount[randType-1].second!=1)
                randAmount=PackageInfo.typeToAmount[randType-1].second
            WareHouse.currentOrders.add(Order(randType, randAmount))
            typeToAmount[randType-1] = typeToAmount[randType-1].first to typeToAmount[randType-1].second-randAmount
        }
        else {
            throw Exception("Кончилось что-то")
        }

    }
}


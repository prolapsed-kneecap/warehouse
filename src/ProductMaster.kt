import PackageInfo.typeToAmount
import java.lang.Exception

class ProductMaster {
    fun discountAndRemove() {
        PackageInfo.packages.forEach {
            if (it.shelfLife == 1) {
                it.price /= 2
            }
            if (it.shelfLife <= 0) {
                typeToAmount[it.type - 1] = typeToAmount[it.type - 1].first to typeToAmount[it.type - 1].second - 1
                PackageInfo.packages.removeIf { it.weight == 0 }
            }
        }
    }

    fun orderAll(orders: MutableList<Order>) {
        WareHouse.stores.forEach {
            it.order()
        }
        printAllInfo()
        /*orders.forEach {
            if (PackageInfo.typeToAmount[it.type - 1].second >= it.amount) {
                printAllInfo()
            } else {
                throw Exception("Заказ не может быть принят: Не хватает упаковок данного типа")
            }
        }*/
    }

    fun deliver() {
        WareHouse.currentOrders.forEach {
            for (i in 0..it.amount) {
                PackageInfo.packages.remove(OptPackage(it.type, it.amount))
            }
        }
        WareHouse.currentOrders.clear()
    }

    fun dayTick() {
        deliver()
        PackageInfo.packages.forEach {
            it.shelfLife -= 1
        }
        discountAndRemove()
        orderAll(WareHouse.currentOrders)
    }

    fun printAllInfo() {
        println(PackageInfo.packages)
        println(typeToAmount)
        println(WareHouse.currentOrders)
    }
}
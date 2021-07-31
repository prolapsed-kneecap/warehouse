object PackageInfo {
    var packages = mutableListOf<OptPackage>(
        OptPackage(1, 10, 5, 15, 20),
        OptPackage(1, 10, 5, 15, 20),
        OptPackage(1, 10, 5, 15, 20),
        OptPackage(1, 10, 5, 15, 20),

        OptPackage(2, 5, 10, 5, 50),
        OptPackage(2, 5, 10, 5, 50),
        OptPackage(2, 5, 10, 5, 50),


        OptPackage(3, 50, 1, 10, 100),
        OptPackage(3, 50, 1, 10, 100),
        OptPackage(3, 50, 1, 10, 100)
        )
    var typeToAmount = mutableListOf<Pair<Int, Int>>(
        1 to 4,
        2 to 3,
        3 to 3
    )
}
object WareHouse {
    var stores = mutableListOf<Store>(
        Store(),
        Store(),
        Store()
    )
    var currentOrders = mutableListOf<Order>()
}
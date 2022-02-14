import 'package:flutter_model/page/goods_detail/view.dart';
import 'package:flutter_model/page/goods_list/view.dart';
import 'package:flutter_model/page/home/view.dart';
import 'package:get/get_navigation/src/routes/get_route.dart';

part 'app_routes.dart';

class AppPages {
  AppPages._();

  static const initial = AppRoutes.home;

  static final routes = [
    GetPage(
      name: Paths.home,
      page: () => HomePage(),
    ),
    GetPage(
      name: Paths.goodsList,
      page: () => GoodsListPage(),
    ),
    GetPage(
      name: Paths.goodsDetail,
      page: () => GoodsDetailPage(),
    ),
  ];
}

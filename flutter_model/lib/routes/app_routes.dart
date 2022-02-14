part of 'app_pages.dart';

abstract class AppRoutes {
  AppRoutes._();

  static const home = Paths.home;
  static const goodsList = Paths.goodsList;
  static const goodsDetail = Paths.goodsDetail;
}

abstract class Paths {
  static const home = '/home';
  static const goodsList = '/goodsList';
  static const goodsDetail = '/goodsDetail';
}

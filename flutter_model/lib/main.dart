import 'dart:ui';

import 'package:flutter/material.dart';
import 'package:flutter_model/logger/logger_utils.dart';
import 'package:flutter_model/routes/app_pages.dart';
import 'package:flutter_model/services/global_service.dart';
import 'package:get/get.dart';

/// 初始化服务
Future initServices() async {
  await Get.putAsync(() => GlobalService().init());
}

void main() async {
  //初始化服务
  await initServices();

  //获取默认路由
  String initRoute = window.defaultRouteName;
  //启动app
  runApp(MyApp(initRoute: initRoute));
}

class MyApp extends StatelessWidget {
  final String initRoute;

  const MyApp({
    Key? key,
    required this.initRoute,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return GetMaterialApp(
      debugShowCheckedModeBanner: false,
      enableLog: true,
      logWriterCallback: Logger.write,
      initialRoute: initRoute,
      getPages: AppPages.routes,
    );
  }
}

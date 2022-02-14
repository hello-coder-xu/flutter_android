import 'package:flutter/material.dart';
import 'package:flutter_model/logger/logger_utils.dart';
import 'package:flutter_model/routes/app_pages.dart';
import 'package:get/get.dart';

import 'logic.dart';

class HomePage extends StatelessWidget {
  final logic = Get.put(HomeLogic());
  final state = Get.find<HomeLogic>().state;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('flutter首页'),
        centerTitle: true,
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            ElevatedButton(
              child: const Text('flutter商品列表'),
              onPressed: () {
                Logger.write('${Get.currentRoute} flutter商品列表');
                Get.toNamed(AppRoutes.goodsList, preventDuplicates: false);
              },
            ),
            ElevatedButton(
              child: const Text('flutter商品详情'),
              onPressed: () {
                Logger.write('${Get.currentRoute} flutter商品详情');
                Get.toNamed(AppRoutes.goodsDetail, preventDuplicates: false);
              },
            ),
            ElevatedButton(
              onPressed: () {
                Logger.write('${Get.currentRoute} 退出');
                Get.back();
              },
              child: const Text('退出'),
            ),
          ],
        ),
      ),
    );
  }
}

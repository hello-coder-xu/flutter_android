import 'package:flutter/services.dart';
import 'package:flutter_model/logger/logger_utils.dart';
import 'package:get/get.dart';
import 'package:get_storage/get_storage.dart';

///全局服务
class GlobalService extends GetxService {
  static GlobalService get to => Get.find();

  //与原生交互
  late MethodChannel _channel;

  Future<GlobalService> init() async {
    await GetStorage.init();
    initChannel();
    return this;
  }

  ///初始化-原生与flutter通信
  void initChannel() {
    _channel = const MethodChannel('flutter_android');
    requestChannel();
  }

  ///接收-原生方法
  void requestChannel() {
    _channel.setMethodCallHandler((call) async {
      if (call.method == 'event') {
        Logger.write('接收event 参数：${call.arguments}');
      } else {
        throw Exception('not implemented ${call.method}');
      }
    });
  }

  ///发送-执行原生方法
  void sendChannel({required String name, dynamic arguments}) {
    _channel.invokeMethod<void>(name, arguments);
  }
}

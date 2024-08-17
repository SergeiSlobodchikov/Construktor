# Construktor
Взял отпусе на неделю с 19 по 25 августа чтобы занятся кодом, могли бы дать время и адрес почты или месенджера чтобы спрашивать. 
мой cerhclobodhikow@mail.ru

Ошибки
1) Записку и пояснение к проекту нужно
2) Приложенеи не работоспособно
Краш - легко. 2 раза добавил делальку. Рекомендую вообще запускать monkey test для приложения

FATAL EXCEPTION: main
Process: com.example.construktor, PID: 8247
java.lang.NumberFormatException: For input string: ""
at java.lang.Integer.parseInt(Integer.java:807)
at java.lang.Integer.parseInt(Integer.java:915)
at com.example.construktor.SetAdapter.onBindViewHolder$lambda$1(SetAdapter.kt:55)
at com.example.construktor.SetAdapter.$r8$lambda$iJJTleNzHBD5dvjL8WgtyHr9f-w(Unknown Source:0)
at com.example.construktor.SetAdapter$$ExternalSyntheticLambda0.onClick(D8$$SyntheticClass:0)
at android.view.View.performClick(View.java:8047)
at android.widget.TextView.performClick(TextView.java:17792)
at com.google.android.material.button.MaterialButton.performClick(MaterialButton.java:1218)
at android.view.View.performClickInternal(View.java:8024)
at android.view.View.-$$Nest$mperformClickInternal(Unknown Source:0)
at android.view.View$PerformClick.run(View.java:31890)
at android.os.Handler.handleCallback(Handler.java:958)
at android.os.Handler.dispatchMessage(Handler.java:99)
at android.os.Looper.loopOnce(Looper.java:230)
at android.os.Looper.loop(Looper.java:319)
at android.app.ActivityThread.main(ActivityThread.java:8919)
at java.lang.reflect.Method.invoke(Native Method)
at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:578)
at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:1103)

3) Декомпозиции по слоям нет. Никакой MV* паттерн не применен
4) Работы с базой или сетью нет

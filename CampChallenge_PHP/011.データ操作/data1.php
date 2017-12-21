<html>
  <head>
    <title>入力データ取得</title>
  </head>
  <body>
    <form action="./data1_2.php" method="post">
      <label>名前</label>
      <input type="text" name="name"><br>
      <label>男性</label>
      <input type="radio" name="gander" value="男性">
      <label>女性</label>
      <input type="radio" name="gander" value="女性"><br>
      <label>趣味</label>
      <input type="textarea" name="hobby">
      <input type="submit">
    </form>
  </body>
</html>

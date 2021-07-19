<?php

var_dump($_FILES);  

if ($_FILES['file']['error'] > 0) {
	switch ($_FILES['file']['error']) {
	# code...
	case '1':
		# code...
		echo "文件过大";
		break;
	case '2':
		# code...
		echo "文件超出指定大小";
		break;
	case '3':
		# code...
		echo "只有部分文件被上传";
		break;
	case '4':
		# code...
		echo "文件没有被上传";
		break;
	case '6':
		# code...
		echo "找不到指定文件夹";
		break;
	case '7':
		# code...
		echo "文件写入失败";
		break;
	default:
		echo '上传出错<br/>';
	}
	
}else{
	
	$MAX_FILE_SIZE = 100000;
    if ($_FILES['file']['size'] > $MAX_FILE_SIZE) {
        //判断，如果上传的文件，大小超出了我们给的限制范围，退上传并产生错误提示
        exit("文件超出指定大小");
    }

}




?>
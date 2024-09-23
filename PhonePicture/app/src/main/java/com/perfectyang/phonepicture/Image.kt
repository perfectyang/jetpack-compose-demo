package com.perfectyang.phonepicture

import android.content.Context
import android.net.Uri
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
import kotlinx.coroutines.launch

@Composable
fun ImageGallery() {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    // 请求读写权限
    val requestPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { isGranted ->
            if (isGranted) {
                // 权限已授予，获取图片相册
                coroutineScope.launch {
//                    getImagesFromGallery(context)
                }
            } else {
                // 权限被拒绝
                // 显示错误信息或处理其他情况
            }
        }
    )

    // 申请读写权限
    LaunchedEffect(key1 = Unit) {
        requestPermissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
    }

    // 图片列表
    val imageUris = remember { mutableStateListOf<Uri>() }

    // 获取图片相册
    fun getImagesFromGallery(context: Context) {
        val projection = arrayOf(MediaStore.Images.Media._ID, MediaStore.Images.Media.DATA)
        val selection = MediaStore.Images.Media.DATA + " like ? "
        val selectionArgs = arrayOf("%${MediaStore.Images.Media.EXTERNAL_CONTENT_URI.path}%")
        val cursor = context.contentResolver.query(
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
            projection, selection, selectionArgs, null)

        cursor?.use {
            if (cursor.moveToFirst()) {
                do {
                    val imagePath = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA))
                    imageUris.add(imagePath.toUri())
                } while (cursor.moveToNext())
            }
        }
    }

    // 显示图片
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            items(imageUris) { imageUri ->
                Image(
                    bitmap = ContextCompat.getDrawable(context, imageUri.toString())?.asImageBitmap()!!,
                    contentDescription = "Image from Gallery",
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

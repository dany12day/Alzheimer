package com.example.alzheimer.Documents

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.text.InputType
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.AdapterView
import android.widget.EditText
import android.widget.ListView
import androidx.core.content.FileProvider
import com.example.alzheimer.R
import com.example.alzheimer.Util.CurrentUser
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.io.File
import java.io.IOException
import java.security.AccessController.getContext
import java.text.SimpleDateFormat
import java.util.*

class DocumentsActivity : AppCompatActivity() {
    private lateinit var documentAdapter: DocumentAdapter
    private lateinit var documentsList: ListView
    private lateinit var image: DocumentModel
    val REQUEST_IMAGE_CAPTURE = 1
    val IMAGE_PICK_CODE = 2

    var isOpen = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_documents)

        documentsList = findViewById<ListView>(R.id.documentsList)
        registerForContextMenu(documentsList)
        documentsList.setOnItemClickListener { parent, view, position, id ->
            val document = documentAdapter.getItem(position) as DocumentModel
            val intent = Intent(Intent.ACTION_VIEW)
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            intent.setDataAndType(document.imageUri, "image/*")
            startActivity(intent)
        }
        documentAdapter = DocumentAdapter(this)
        documentsList.adapter = documentAdapter

        documentsList.visibility = View.VISIBLE

        val fabOpen = AnimationUtils.loadAnimation(this, R.anim.fab_open)
        val fabClose = AnimationUtils.loadAnimation(this, R.anim.fab_close)
        val fabRClockwise = AnimationUtils.loadAnimation(this, R.anim.rotate_clockwise)
        val fabRAntiClockwise = AnimationUtils.loadAnimation(this, R.anim.rotate_anticlockwise)

        val addButton = findViewById<FloatingActionButton>(R.id.add_document_fab)
        val fileButton = findViewById<FloatingActionButton>(R.id.fileButton)
        val cameraButton = findViewById<FloatingActionButton>(R.id.cameraButton)
        addButton.setOnClickListener{
            if(isOpen){
                fileButton.startAnimation(fabClose)
                cameraButton.startAnimation(fabClose)
                addButton.startAnimation(fabRClockwise)

                isOpen = false
            }
            else
            {
                fileButton.startAnimation(fabOpen)
                cameraButton.startAnimation(fabOpen)
                addButton.startAnimation(fabRAntiClockwise)

                fileButton.isClickable
                cameraButton.isClickable

                isOpen = true
            }

            fileButton.setOnClickListener{
                pickImageFromGallery()
            }

            cameraButton.setOnClickListener { takePicture() }
        }
    }

    private fun pickImageFromGallery() {
        image = DocumentModel("", Uri.EMPTY)
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_PICK_CODE)
    }

    private fun takePicture(){
        image = DocumentModel("", Uri.EMPTY)
        dispatchTakePictureIntent()
    }

    fun showTitleDialog(){
        val builder: AlertDialog.Builder = android.app.AlertDialog.Builder(this)
        builder.setTitle("Choose document title")
        val input = EditText(this)

        input.setHint("Enter document title")
        input.inputType = InputType.TYPE_CLASS_TEXT
        builder.setView(input)

        builder.setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->
            image.title = input.text.toString()
            CurrentUser.userInfo.userData.documentsList.add(image)
            documentAdapter.notifyDataSetChanged()
        })

        builder.show()
    }

    private fun dispatchTakePictureIntent() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(packageManager)?.also {
                // Create the File where the photo should go
                val photoFile: File? = try {
                    createImageFile()
                } catch (ex: IOException) {
                    null
                }
                photoFile?.also {
                    image.imageUri = FileProvider.getUriForFile(
                        this,
                        "com.example.android.fileprovider",
                        it
                    )
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, image.imageUri)
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            showTitleDialog()
        }
        else
            if(requestCode == IMAGE_PICK_CODE && resultCode == RESULT_OK){
                image.imageUri = data?.data!!
                showTitleDialog()
            }
    }

    private fun createImageFile(): File {
        // Create an image file name
        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val storageDir: File = getExternalFilesDir(Environment.DIRECTORY_PICTURES)!!
        return File.createTempFile(
            "JPEG_${timeStamp}_", /* prefix */
            ".jpg", /* suffix */
            storageDir /* directory */
        ).apply {
            // Save a file: path for use with ACTION_VIEW intents
            val currentPhotoPath = absolutePath
        }
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        if(v!!.id == R.id.documentsList){
            val info = menuInfo as AdapterView.AdapterContextMenuInfo
            val selectedDocument = documentAdapter.getItem(info.position) as DocumentModel

            menu!!.setHeaderTitle("${selectedDocument.title}")
            menuInflater.inflate(R.menu.documents_menu, menu)
        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val info = item.menuInfo as AdapterView.AdapterContextMenuInfo
        val document = documentAdapter.getItem(info.position)

        when(item.itemId){
            R.id.deleteDocument -> {
                CurrentUser.userInfo.userData.documentsList.remove(document)
                documentAdapter.notifyDataSetChanged()
            }
        }
        return super.onContextItemSelected(item)
    }
}
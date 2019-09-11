package com.example.dapindao.WebEditorTools;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.dapindao.R;

import java.util.Arrays;
import java.util.List;

/**
 * @author Rex on 2019/6/20.
 */
public class EditToolAdapter extends BaseAdapter {

    private Context mContext;

    public EditToolAdapter(Context context) {
        mContext = context;
    }

    private List<ChooseDialogData> dataList = Arrays.asList(
            new ChooseDialogData("图片",ChooseDialog.Type.Image.name(), R.drawable.insert_img),
            new ChooseDialogData("音频", ChooseDialog.Type.Audio.name(),R.drawable.audio),
            new ChooseDialogData("视频", ChooseDialog.Type.Video.name(), R.drawable.video),
            new ChooseDialogData("文件",ChooseDialog.Type.File.name(),  R.drawable.file),
            new ChooseDialogData("换行",ChooseDialog.Type.NewLine.name(), R.drawable.new_line),
            new ChooseDialogData("字体颜色",ChooseDialog.Type.TextColor.name(), R.drawable.color),
            new ChooseDialogData("标题",ChooseDialog.Type.Heading.name(), R.drawable.hhh),
            new ChooseDialogData("加粗",ChooseDialog.Type.Blod.name(), R.drawable.bold),
            new ChooseDialogData("斜体",ChooseDialog.Type.Italic.name(), R.drawable.italic),
            new ChooseDialogData("下标",ChooseDialog.Type.Subscript.name(), R.drawable.subscript),
            new ChooseDialogData("上标", ChooseDialog.Type.Superscript.name(),R.drawable.subscript),
            new ChooseDialogData("加删除线", ChooseDialog.Type.Strikethrough.name(), R.drawable.strikethrough),
            new ChooseDialogData("下划线", ChooseDialog.Type.Underline.name(), R.drawable.underline),
            new ChooseDialogData("左对齐", ChooseDialog.Type.JustifyLeft.name(), R.drawable.justify_left),
            new ChooseDialogData("居中", ChooseDialog.Type.JustifyCenter.name(),R.drawable.justify_center),
            new ChooseDialogData("右对齐",ChooseDialog.Type.JustifyRight.name(), R.drawable.justify_right),
            new ChooseDialogData("引用",ChooseDialog.Type.Blockquote.name(), R.drawable.blockquote),
            new ChooseDialogData("撤销",ChooseDialog.Type.Undo.name(), R.drawable.undo),
            new ChooseDialogData("重做",ChooseDialog.Type.Redo.name(), R.drawable.redo),
            new ChooseDialogData("缩进",ChooseDialog.Type.Indent.name(),R.drawable.indent),
            new ChooseDialogData("悬挂缩进", ChooseDialog.Type.Outdent.name(),R.drawable.outdent),
            new ChooseDialogData("插入链接",ChooseDialog.Type.InsertLink.name(), R.drawable.insert_link),
            new ChooseDialogData("复选框",ChooseDialog.Type.Checkbox.name(), R.drawable.check_box),
            new ChooseDialogData("文本背景颜色",ChooseDialog.Type.TextBackgroundColor.name(), R.drawable.background_color),
            new ChooseDialogData("字体大小",ChooseDialog.Type.FontSize.name(), R.drawable.font_size),
            new ChooseDialogData("无序表",ChooseDialog.Type.UnorderedList.name(), R.drawable.unordered_list),
            new ChooseDialogData("有序表",ChooseDialog.Type.OrderedList.name(), R.drawable.ordered_list)
    );

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public ChooseDialogData getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.item_gv_edit, null);
        }
        ImageView imageView = convertView.findViewById(R.id.ivIcon);
        TextView tvDes = convertView.findViewById(R.id.tvDes);
        imageView.setImageResource(dataList.get(position).iconId);
        tvDes.setText(dataList.get(position).name);
        return convertView;
    }
}

package org.konstantin.ui.Stories;

import org.konstantin.tyangram.MessagesController;
import org.konstantin.tyangram.UserConfig;
import org.konstantin.tgnet.AbstractSerializedData;
import org.konstantin.tgnet.InputSerializedData;
import org.konstantin.tgnet.OutputSerializedData;
import org.konstantin.tgnet.TLRPC;
import org.konstantin.tgnet.tl.TL_stories;

public class MessageMediaStoryFull extends TLRPC.TL_messageMediaStory {

    public static int constructor = 0xc79aee1d;

    public void readParams(InputSerializedData stream, boolean exception) {
        user_id = stream.readInt64(exception);
        id = stream.readInt32(exception);
        storyItem = TL_stories.StoryItem.TLdeserialize(stream, stream.readInt32(exception), exception);
        via_mention = stream.readBool(exception);
        peer = MessagesController.getInstance(UserConfig.selectedAccount).getPeer(user_id);
    }

    public void serializeToStream(OutputSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(user_id);
        stream.writeInt32(id);
        storyItem.serializeToStream(stream);
        stream.writeBool(via_mention);
    }
}
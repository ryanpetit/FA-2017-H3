# FA-2017-H3
This homework will deal with the creation of Fragments and will also require students to flex their layout muscles.

For the final portion of this homework:

1. Create a new empty Actvity named 'NewActivity'

2. In the onReplyClick override in your ReceiverActivity, add the following code (assumes you have a SendMessageFragment 
   private member variable named 'sendMessageFragment').
  
        sendMessageFragment = new SendMessageFragment();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.receiver_fragment_container, sendMessageFragment);
        transaction.addToBackStack(null);
        transaction.commit();

3. Make sure that you implement the SendMessageFragment.OnSendButtonClick interface on the ReceiverActivity.

4. In the onSenderClick override, add code to navigate to the NewActivity
